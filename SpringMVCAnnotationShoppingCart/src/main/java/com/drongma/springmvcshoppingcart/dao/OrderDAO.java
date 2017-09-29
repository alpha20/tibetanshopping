package com.drongma.springmvcshoppingcart.dao;

import java.util.List;

import com.drongma.springmvcshoppingcart.model.CartInfo;
import com.drongma.springmvcshoppingcart.model.OrderDetailInfo;
import com.drongma.springmvcshoppingcart.model.OrderInfo;
import com.drongma.springmvcshoppingcart.model.PaginationResult;
 
public interface OrderDAO {
 
    public void saveOrder(CartInfo cartInfo);
 
    public PaginationResult<OrderInfo> listOrderInfo(int page,
            int maxResult, int maxNavigationPage);
    
    public OrderInfo getOrderInfo(String orderId);
    
    public List<OrderDetailInfo> listOrderDetailInfos(String orderId);
 
}
