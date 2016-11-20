package edu.nju.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.nju.dao.RiskDao;
import edu.nju.vo.StatVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.nju.dao.StatisticsDao;
import edu.nju.model.RiskItem;
import edu.nju.service.StatisticsService;

import javax.persistence.Tuple;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    private StatisticsDao dao;

    @Autowired
    private RiskDao riskDao;

    @Override
    public List<StatVO> identifyMost(Date startTime, Date endTime) {
        List<Tuple> data = dao.identifyMost(startTime, endTime);
        return this.getVOs(data);
    }

    @Override
    public List<StatVO> happenMost(Date startTime, Date endTime) {
        List<Tuple> data = dao.happenMost(startTime, endTime);
        return this.getVOs(data);
    }

    private List<StatVO> getVOs(List<Tuple> data) {
        ArrayList<StatVO> result = new ArrayList<>();
        for (Tuple t : data) {
            int rid = (int) t.get(0);
            RiskItem risk = this.riskDao.getItemById(rid);
            StatVO vo = new StatVO();
            vo.setRisk(risk);
            vo.setCount((long)t.get(1));
            result.add(vo);
        }
        return result;
    }

}
