package com.jtx.admin.controller;

import com.jtx.admin.common.ServerResponse;
import com.jtx.admin.pojo.Coupons;
import com.jtx.admin.service.ICouponsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Zeki
 * @date 2018-4-10
 */
@Controller
@RequestMapping("/coupons")
public class CouponsController {

    @Autowired
    private ICouponsService couponsService;

    @RequestMapping("/list")
    @ResponseBody
    public ServerResponse couponsList(@RequestParam(value = "pageSize",defaultValue = "10") int pageSize,
                                      @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                      @RequestParam(value = "preferentialWay",required = false) Integer preferentialWay){
        return couponsService.couponsList(pageSize, pageNum, preferentialWay);
    }

    @RequestMapping("/add")
    @ResponseBody
    public ServerResponse couponsAdd(String name,
                                     String couponsDesc,
                                     Integer preferentialWay,
                                     String preferentialInfo,
                                     String scope){
        Coupons coupons = new Coupons();
        coupons.setName(name);
        coupons.setCouponsDesc(couponsDesc);
        coupons.setPreferentialWay(preferentialWay);
        coupons.setPreferentialInfo(preferentialInfo);
        coupons.setScope(scope);
        return couponsService.couponsAdd(coupons);
    }

    @RequestMapping("/getOne")
    @ResponseBody
    public ServerResponse couponsGetOne(Integer couponsId){
        return couponsService.couponsGetOne(couponsId);
    }

    @RequestMapping("/update")
    @ResponseBody
    public ServerResponse couponsUpdate(@RequestParam(value = "couponsId",required = true)Integer couponsId,
                                        @RequestParam(value = "name",required = false) String name,
                                        @RequestParam(value = "couponsDesc",required = false) String couponsDesc,
                                        @RequestParam(value = "preferentialWay",required = false) Integer preferentialWay,
                                        @RequestParam(value = "preferentialInfo",required = false) String preferentialInfo,
                                        @RequestParam(value = "scope",required = false) String scope){
        Coupons coupons = new Coupons();
        coupons.setId(couponsId);
        coupons.setName(StringUtils.isBlank(name) ? null : name);
        coupons.setCouponsDesc(StringUtils.isBlank(couponsDesc) ? null : couponsDesc);
        coupons.setPreferentialWay(preferentialWay);
        coupons.setPreferentialInfo(StringUtils.isBlank(preferentialInfo) ? null : preferentialInfo);
        coupons.setScope(StringUtils.isBlank(scope) ? null : scope);
        System.out.println(coupons.toString());
        return couponsService.couponsUpdate(coupons);
    }
}
