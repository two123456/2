package com.superhero.netctoss.test;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.superhero.netctoos.bean.PageBean;
import com.superhero.netctoos.bean.TariffBean;
import com.superhero.netctoos.tariffmag.dao.ITariffQueryDao;
import com.superhero.netctoos.tariffmag.handleservice.ITariffHandleService;
import com.superhero.netctoos.tariffmag.queryservice.ITariffQueryService;
import com.superhero.netctoos.tariffmag.repository.ITariffrepository;

/***
 * 资费测试类
 * @author gongtao
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class TariffServiceimplTest {
    @Resource
	private ITariffHandleService tariffrepository;
	@Resource
    private  ITariffQueryService ITariffQueryDao;
    @Test
	public void saveTariffBean() {
		TariffBean tariffBean=new TariffBean();
		tariffBean.setTariffName("包年");
		tariffBean.setTariffType(1);
		tariffBean.setTimeLengh(20);
		tariffBean.setBasicCost(200);		
		tariffBean.setUnitCost(500);
		tariffBean.setTariffInfo("不知道");
		tariffBean.setTariffState(0);
		tariffrepository.saveTariffBean(tariffBean);
		
	}
    @Test
    public void updateTariffBean() {
     	TariffBean tariff=ITariffQueryDao.getTariffById(1L);
    	tariff.setTariffType(0);
    	tariff.setTimeLengh(18);
    	tariff.setBasicCost(100);		
    	tariff.setUnitCost(400);
    	tariff.setTariffInfo("不晓得");
    	tariff.setTariffState(1);
        tariffrepository.updateTariffBean(tariff);
    }
    @Test
    public void deleteTariffBean() {
    	TariffBean tariff=ITariffQueryDao.getTariffById(2L);
    	tariffrepository.deleteTariffBean(tariff);
    	
    }
    @Test
    public void getTariffById() {
    	TariffBean tar=ITariffQueryDao.getTariffById(2L);
    	System.out.println(tar);
    }
    @Test
    public void findAll() {
      PageBean page=new PageBean(1,3);
		Map params = new HashMap<>();
      page=ITariffQueryDao.findAll(params, page);
 System.out.println(page);
    }
    
}
