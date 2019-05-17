import com.github.Customer;
import com.github.CustomerDto;
import com.github.OrderItem;
import com.github.OrderItemDto;
import com.github.mapper.CustomerMapper;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;


/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午12:49 2019/5/17
 */
public class CustomerMapperTest {

    @Test
    public void testMapDtoToEntity() {



        CustomerDto customerDto = new CustomerDto();
        customerDto.id = 10L;
        customerDto.customerName = "Filip";
        OrderItemDto order1 = new OrderItemDto();
        order1.name = "Table";
        order1.quantity = 2L;

        customerDto.orders = new ArrayList<>(Collections.singleton(order1));

        Customer customer = CustomerMapper.mapper.toCustomer(customerDto);

        assertThat(customer.getOrderItems())
                .extracting("name","quantity")
                .containsExactly(tuple("Table",2L));

    }

    @Test
    public void testEntityDtoToDto() {

        Customer customer = new Customer();
        customer.setId( 10L );
        customer.setName( "Filip" );
        OrderItem order1 = new OrderItem();
        order1.setName( "Table" );
        order1.setQuantity( 2L );
        customer.setOrderItems( Collections.singleton( order1 ) );

        CustomerDto customerDto = CustomerMapper.mapper.fromCustomer( customer );

        assertThat( customerDto.id ).isEqualTo( 10 );
        assertThat( customerDto.customerName ).isEqualTo( "Filip" );
        assertThat( customerDto.orders )
                .extracting( "name", "quantity" )
                .containsExactly( tuple( "Table", 2L ) );
    }
}
