package small.woods.community.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
public class PaginationDTO {
    private List<QuestionDTO> questions;
    private Boolean showPrevious;//上一页
    private Boolean showFirstPage;//首页
    private Boolean showNext;//下一页
    private Boolean showEndPage;//末页
    private Integer page;
    private List<Integer> pages;
    private Integer totalPage;
    public void setPagination(Integer totalCount, Integer page, Integer size) {
        this.page = page;
        totalPage =0;
        if(totalCount % size ==0){
            totalPage = totalCount/size;
        }else {
            totalPage = totalCount/size +1 ;
        }
        pages  = new ArrayList<Integer>();
        pages.add(page);
        //右边的数
        for (int i=page-3;i<page;i++){
            if(i>0){
                pages.add(i);
            }
        }
        //左边的数
        for (int i=page+1;i<=page+3;i++){
            if(i<=totalPage){
                pages.add(i);
            }
        }
        Collections.sort(pages);
        //是否展示上一页
        if(page == 1){
            showPrevious = false;
        }else {
            showPrevious = true;
        }
        //是否展示下一页
        if(page == totalPage){
            showNext = false;
        }else {
            showNext = true;
        }

        //是否展示第一页
        if(pages.contains(1)){
            showFirstPage = false;
        }else {
            showFirstPage = true;
        }

        //是否展示最后一页
        if(pages.contains(totalPage)){
            showEndPage = false;
        }else {
            showEndPage = true;
        }
    }
}
