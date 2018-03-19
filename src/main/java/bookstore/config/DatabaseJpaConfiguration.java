package bookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef="entityManagerFactory",transactionManagerRef="transactionManager",basePackages = {
		"bookstore.repositories"
		})
public class DatabaseJpaConfiguration {
    @Autowired
    @Qualifier("primaryDS")
    private DataSource primaryDS;
    /**
     * 鎸囧畾鏈湴瀹瑰櫒绠＄悊 EntityManagerFactory,浠庤�岃繘琛岀粏绮掑害鎺у埗
     *\
     * @param jpaVendorAdapter 鎸囧畾瀹炵幇鍘傚晢涓撶敤鐗规�э紝鍗砱enerateDdl= false琛ㄧず涓嶈嚜鍔ㄧ敓鎴怐DL锛宒atabase= MySQL琛ㄧず浣跨敤MySQL鏁版嵁搴擄紱
     * @return 鏈湴瀹瑰櫒绠＄悊EntityManagerFactory
     */
    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(JpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean lemfb = new LocalContainerEntityManagerFactoryBean();
        lemfb.setDataSource(primaryDS);
        lemfb.setJpaVendorAdapter(jpaVendorAdapter);
        lemfb.setPackagesToScan(
        		"bookstore.entity"
        		);
        lemfb.setJpaProperties(getJpaProperties());
        return lemfb;
    }

    private Properties getJpaProperties() {
        return new Properties() {
            private static final long serialVersionUID = 9102937342519479384L;

            {
//                setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
                setProperty("hibernate.hbm2ddl.auto", "update");
                setProperty("hibernate.ejb.naming_strategy", "org.hibernate.cfg.ImprovedNamingStrategy");
                setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
                setProperty("hibernate.show_sql", "true");
                setProperty("hibernate.format_sql", "true");
            }
        };
    }
    @Bean
    @Primary
    public JpaTransactionManager transactionManager(JpaVendorAdapter jpaVendorAdapter) {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory(jpaVendorAdapter).getObject());
        return jpaTransactionManager;
    }
}
