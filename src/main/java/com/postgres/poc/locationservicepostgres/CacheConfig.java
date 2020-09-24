package com.postgres.poc.locationservicepostgres;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.cache.CacheAtomicityMode;
import org.apache.ignite.cache.CacheMode;
import org.apache.ignite.cache.spring.SpringCacheManager;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.spi.communication.tcp.TcpCommunicationSpi;
import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;
import org.apache.ignite.spi.discovery.tcp.ipfinder.multicast.TcpDiscoveryMulticastIpFinder;
//import org.apache.ignite.springdata22.repository.config.EnableIgniteRepositories;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
public class CacheConfig {

    /*@Bean
    public Ignite igniteInstance() {
        IgniteConfiguration cfg = new IgniteConfiguration();
        cfg.setClientMode(true);

        return Ignition.start(cfg);
    }*/

    @Bean
    public IgniteConfiguration igniteConfiguration(){
        IgniteConfiguration cfg = new IgniteConfiguration();
        cfg.setClientMode(true);
        return cfg;
    }

    @Bean
    public CacheManager cacheManager() {
        SpringCacheManager cacheManager = new SpringCacheManager();
        //cacheManager.setConfiguration(igniteConfiguration());
        cacheManager.setConfiguration(igniteConfiguration());
        return cacheManager;
    }

    /*@Bean
    public IgniteConfiguration igniteConfiguration() {
        IgniteConfiguration igniteConfiguration = new IgniteConfiguration();
        //igniteConfiguration.setGridName("testGrid");
        igniteConfiguration.setPeerClassLoadingEnabled(true);
        igniteConfiguration.setLocalHost("127.0.0.1");

        TcpDiscoverySpi tcpDiscoverySpi = new TcpDiscoverySpi();
        TcpDiscoveryMulticastIpFinder ipFinder = new TcpDiscoveryMulticastIpFinder();
        ipFinder.setAddresses(Collections.singletonList("127.0.0.1:47500..47509"));
        tcpDiscoverySpi.setIpFinder(ipFinder);
        tcpDiscoverySpi.setLocalPort(47500);
        tcpDiscoverySpi.setLocalPortRange(9); // This is optional

        igniteConfiguration.setDiscoverySpi(tcpDiscoverySpi);

        TcpCommunicationSpi communicationSpi = new TcpCommunicationSpi();
        communicationSpi.setLocalAddress("localhost");
        communicationSpi.setLocalPort(48100);
        communicationSpi.setSlowClientQueueLimit(1000);

        igniteConfiguration.setCommunicationSpi(communicationSpi);
        igniteConfiguration.setCacheConfiguration(cacheConfiguration());

        return igniteConfiguration;
    }

    @Bean(name = "cacheConfiguration")
    public CacheConfiguration[] cacheConfiguration() {

        List<CacheConfiguration> cacheConfigurations = new ArrayList<>();

        CacheConfiguration cacheCon1 = new CacheConfiguration();
        cacheCon1.setAtomicityMode(CacheAtomicityMode.ATOMIC);
        cacheCon1.setCacheMode(CacheMode.REPLICATED);
        cacheCon1.setName("City");
        cacheCon1.setWriteThrough(false);
        cacheCon1.setReadThrough(false);
        cacheCon1.setWriteBehindEnabled(false);
        cacheCon1.setBackups(1);
        cacheCon1.setStatisticsEnabled(true);

        CacheConfiguration cacheCon2 = new CacheConfiguration();
        cacheCon2.setAtomicityMode(CacheAtomicityMode.ATOMIC);
        cacheCon2.setCacheMode(CacheMode.REPLICATED);
        cacheCon2.setName("Country");
        cacheCon2.setWriteThrough(false);
        cacheCon2.setReadThrough(false);
        cacheCon2.setWriteBehindEnabled(false);
        cacheCon2.setBackups(1);
        cacheCon2.setStatisticsEnabled(true);

        cacheConfigurations.add(cacheCon1);
        cacheConfigurations.add(cacheCon2);

        return cacheConfigurations.toArray(new CacheConfiguration[cacheConfigurations.size()]);
    }*/
}
