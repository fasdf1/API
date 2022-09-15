package com.example.Api.product;

import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Positive;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
@Validated
public class ProductController {

    private final ProductMapper productMapper;
    private final int size = 10;
    public ProductController(ProductMapper productMapper ){
        this.productMapper = productMapper;
    }


    /*
    # POST("/{member-id}")
    : 상품 등록 ( 여러 개 )
      엑셀 등록 , 관리자 페이지에서 관리자만 상품 등록 가능
     */
    @ApiOperation(value = "Excel File 저장",
            notes = "✅ Excel File을 등록합니다.\n - \n " )
    /*@PostMapping("/{member-id}")
    public List<ExcelData> postProducts(@PathVariable("member-id") @Positive long memberId,
                                        @RequestPart("file") MultipartFile file) throws IOException {*/
    //중복 상품 검사 기능 : 개발 기간에 구현 예정
    // 기존 DB에 저장된 productName들을 읽어와 List를 생성
    // 엑셀 파일의 productName이 List에 담겨져 있다면 다음 반복으로 continue
    // 등록되지 않은 ProductName이라면 저장
    @PostMapping("/{member-id}")
    public List<Product> postProducts(@PathVariable("member-id") @Positive long memberId,
                                     @RequestPart("file") MultipartFile file) throws IOException {
        long[] adminIdList = {1, 2, 3, 4, 5};
        for(long i : adminIdList){
            if(memberId == i){
                break;
            }
            else throw new RuntimeException("관리자가 아닙니다.");
        }
        List<ExcelData> dataList = new ArrayList<>();
        List<Product> productList = new ArrayList<>();
        String extension = FilenameUtils.getExtension(file.getOriginalFilename()); // 3

        if (!extension.equals("xlsx") && !extension.equals("xls")) {
            throw new IOException("엑셀파일만 업로드 해주세요.");
        }

        Workbook workbook = null;

        if (extension.equals("xlsx")) {
            workbook = new XSSFWorkbook(file.getInputStream());
        } else if (extension.equals("xls")) {
            workbook = new HSSFWorkbook(file.getInputStream());
        }

        Sheet worksheet = workbook.getSheetAt(0);

        for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) { // 4

            Row row = worksheet.getRow(i);

            ExcelData data = new ExcelData();

            data.setProductId(i);
            data.setImageURL(row.getCell(0).getStringCellValue());
            data.setProductName(row.getCell(1).getStringCellValue());
            String priceValue = row.getCell(2).getStringCellValue().replaceAll(",","");
            // 크롤링한 가격은 텍스트 형식으로 되어 있는 숫자, 3,500에 있는 , 제거
           /* String priceValue2 = priceValue.replaceAll(",","");*/
            long  price = Long.parseLong(priceValue);
            BigDecimal seq = new BigDecimal(price);
            data.setCategoryId((long)row.getCell(3).getNumericCellValue());
            data.setCompany(row.getCell(4).getStringCellValue());
            data.setPrice(seq);
            data.setCreatedAt(LocalDateTime.now());
            dataList.add(data);
            Product product = productMapper.excelDataToProduct(data);
            product.setId(data.getProductId());
            productList.add(product);
        }

        if(dataList.isEmpty()){
            throw new RuntimeException("파일 등록 실패");
        }
        else{

            return productList;
            /*return dataList;*/

        }

    }
/*
# GET("/{member-id}") , Request Parmeters : String productName
: 상품 Id 찾기
  관리자가 수정하거나 삭제할 상품의 ID를 찾기 위해 필요

# PATCH("/{member-id}") , Request Parmeters : String productName
: 관리자가 상품 정보 수정

# DELETE("/{member-id}") , Request Parmeters : long productId
: 관리자가 상품 삭제

# POST("/{member-id}") , Request Parmeters : long productId
: 일반 사용자가 상품 좋아요 등록 / 취소

- 현재 회원이 해당 상품에 좋아요를 누르지 않았다면 -> 새로운 productHeart 등록, product 테이블의 hearts +1
- 현재 회원이 해당 상품에 이미 좋아요를 눌렀다면 -> 해당하는 productHeartId의 값 DB에서 삭제, product 테이블의 hearts -1

# GET("/{product-id}")
: 상품 조회 (상세 페이지 )
 상품에 달린 댓글까지 출력, 조회수 1 증가

# GET("/all"), Request Parmeters : int page , String sortingMethod
!) sortingMethod값에 따라 분기

- 전체 상품 좋아요순 정렬 ( sortingMethod= "byHearts")
- 전체 상품 리뷰순 정렬 ( sortingMethod= "byReviews")
- 전체 상품 조회순 정렬 ( sortingMethod= "byViews")

# GET("/all/{category-id}), Request Parmeters :  int page , String sortingMethod
!) sortingMethod값에 따라 분기

- 전체 상품 카테고리별 좋아요순 정렬  ( sortingMethod= "byHearts")
- 전체 상품 카테고리별 리뷰순 정렬 ( sortingMethod= "byReviews")
- 전체 상품 카테고리별 조회순 정렬 ( sortingMethod= "byViews")

# GET("/allByCompanyType"), Request Parmeters : String company, int page , String sortingMethod
!) sortingMethod값에 따라 분기

- 회사별 전체 상품 좋아요순 정렬  ( sortingMethod= "byHearts")
- 회사별 전체 상품 카테고리별 좋아요순 정렬 ( sortingMethod= "byReviews")
- 회사별 전체 상품 리뷰순 정렬 ( sortingMethod= "byViews")

# GET("/allByCompanyType/{category-id}"), Request Parmeters : String company, int page , String sortingMethod
!) sortingMethod값에 따라 분기

- 회사별 전체 상품 카테고리별 리뷰순 정렬( sortingMethod= "byHearts")
- 회사별 전체 상품 조회순 정렬 ( sortingMethod= "byReviews")
- 회사별 전체 상품 카테고리별 조회순 정렬 ( sortingMethod= "byViews")

     */

}
