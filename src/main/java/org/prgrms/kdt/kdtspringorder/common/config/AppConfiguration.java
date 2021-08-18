package org.prgrms.kdt.kdtspringorder.common.config;

import org.prgrms.kdt.kdtspringorder.order.domain.Order;
import org.prgrms.kdt.kdtspringorder.order.repository.OrderRepositiry;
import org.prgrms.kdt.kdtspringorder.order.service.OrderService;
import org.prgrms.kdt.kdtspringorder.voucher.application.VoucherCommandLine;
import org.prgrms.kdt.kdtspringorder.voucher.domain.Voucher;
import org.prgrms.kdt.kdtspringorder.voucher.repository.VoucherRepository;
import org.prgrms.kdt.kdtspringorder.voucher.service.VoucherService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;
import java.util.UUID;

/**
 * 각 Bean을 정의한 Configuration Meta Data
 */

@Configuration
public class AppConfiguration {

    @Bean
    public VoucherRepository voucherRepository() {
        return
        new VoucherRepository() {
            @Override
            public Optional<Voucher> findById(UUID voucherId) {
                return Optional.empty();
            }
        };
    }

    @Bean
    public OrderRepositiry orderRepositiry() {
        return new OrderRepositiry() {
            @Override
            public void insert(Order order) {

            }
        };
    }

    @Bean
    public VoucherService voucherService() {
        return new VoucherService(voucherRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderService(voucherService(), orderRepositiry());
    }

    @Bean
    public VoucherCommandLine voucherCommandLine() {
        return new VoucherCommandLine(voucherService());
    }


}