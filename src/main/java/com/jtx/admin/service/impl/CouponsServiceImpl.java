package com.jtx.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jtx.admin.common.ServerResponse;
import com.jtx.admin.dao.CouponsMapper;
import com.jtx.admin.pojo.Coupons;
import com.jtx.admin.service.ICouponsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * 优惠卷服务接口实现类
 * @author Zeki
 * @date 2018-4-10
 */
@Service("iCouponsService")
public class CouponsServiceImpl implements ICouponsService {

    @Autowired
    private CouponsMapper couponsMapper;

    @Override
    public ServerResponse couponsList(int pageSize,int pageNum,Integer preferentialWay) {

        PageHelper.startPage(pageNum,pageSize);
        List<Coupons> couponsList = couponsMapper.selectCouponsList(preferentialWay);
        if(CollectionUtils.isEmpty(couponsList)){
            return ServerResponse.createByErrorMessage("空空如也");
        }
        PageInfo pageResult = new PageInfo(couponsList);
        pageResult.setList(couponsList);
        return ServerResponse.createBySuccess("所有的优惠卷信息",pageResult);
    }
    @Override
    public ServerResponse couponsAdd(Coupons coupons){
        Date now = new Date();
        coupons.setCreateTime(now);
        coupons.setUpdateTime(now);
        int result = couponsMapper.insertSelective(coupons);
        if(result > 0){
            return ServerResponse.createBySuccessMessage("新增成功");
        }
        return ServerResponse.createByErrorMessage("新增失败");
    }

    @Override
    public ServerResponse couponsGetOne(Integer couponsId){
        Coupons coupons = couponsMapper.selectByPrimaryKey(couponsId);
        if(null == coupons){
            return ServerResponse.createByErrorMessage("没有找到该优惠卷");
        }
        return ServerResponse.createBySuccess("优惠卷信息如下",coupons);
    }

    @Override
    public ServerResponse couponsUpdate(Coupons coupons) {
        coupons.setUpdateTime(new Date());
        int result = couponsMapper.updateByPrimaryKeySelective(coupons);
        if(result > 0){
            return ServerResponse.createBySuccessMessage("更新成功");
        }
        return ServerResponse.createByErrorMessage("更新失败");
    }
}
