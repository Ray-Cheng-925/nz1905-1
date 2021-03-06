package com.qf.solr.v2.service.controller;

import com.github.pagehelper.PageInfo;
import com.qf.dto.TProductDTO;
import com.qf.entity.TProduct;
import com.qf.solr.v2.service.service.ISearchService;
import com.qf.vo.ResultBean;
import org.apache.solr.client.solrj.SolrQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Ray.Cheng
 * @Date 2020/3/11
 */
@Controller
@RequestMapping("search")
public class SearchController {

    @Autowired
    private ISearchService searchService;



    @RequestMapping("initData")
    @ResponseBody
    public ResultBean initDataToSolr(){
        List<TProductDTO> productDTOList=searchService.initDataToSolr();
        return new ResultBean(0,"全量复制至solr搜引库成功",productDTOList);
    }

    @RequestMapping("keyWord")
    @ResponseBody
    public ResultBean searchByKeyWord(@RequestParam Integer pageNum, @RequestParam Integer pageSize, @RequestParam String keyWord){

        return searchService.searchByKeyWord(pageNum, pageSize, keyWord);

    }

}
