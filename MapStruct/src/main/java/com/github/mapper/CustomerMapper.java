package com.github.mapper;

import com.github.Customer;
import com.github.CustomerDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午12:44 2019/5/17
 */
@Mapper(uses = {OrderItemMapper.class})
public interface CustomerMapper {

    CustomerMapper mapper = Mappers.getMapper(CustomerMapper.class);

    @Mapping(source="orders", target = "orderItems")
    @Mapping(source="customerName", target = "name")
    Customer toCustomer(CustomerDto customerDto);

    @InheritInverseConfiguration
    CustomerDto fromCustomer(Customer customer);
}
