package com.pair7z.echartapi.controller;

import com.pair7z.echartapi.entity.Response;
import com.pair7z.echartapi.entity.Shareholder;
import com.pair7z.echartapi.service.ShareholderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
public class ShareholderController {
    @Autowired
    ShareholderService shareholderService;
    @RequestMapping(value = "/queryAllShareholders",method = RequestMethod.GET)
    public Response queryAllShareholders(){
        List<Shareholder> shareholders=shareholderService.queryAllShareholders();
        Response response=new Response("查询成功",1,shareholders);
        return response;
    }

    @RequestMapping(value = "/addShareholder",method = RequestMethod.POST)
    public Response addShareholder(@RequestBody Shareholder shareholder){
        int status = shareholderService.addShareholder(shareholder);
        if(status==1){
            return new Response("添加成功",1);
        }else{
            return new Response("添加失败",0);
        }
    }

    @RequestMapping(value = "/modifyShare",method = RequestMethod.POST)
    public Response modifyShare(@RequestParam String name,@RequestParam Integer newValue){
        int status = shareholderService.modifyShare(name,newValue);
        if(status==1){
            return new Response("修改成功",1);
        }else{
            return new Response("修改失败",0);
        }
    }

    @RequestMapping(value = "/delShareholderByName",method = RequestMethod.POST)
    public Response delShareholderByName(@RequestParam String name){
        int status = shareholderService.delShareholderByName(name);
        if(status==1){
            return new Response("删除成功",1);
        }else{
            return new Response("删除失败",0);
        }
    }


}
