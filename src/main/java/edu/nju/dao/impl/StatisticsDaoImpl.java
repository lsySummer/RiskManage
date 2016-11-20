package edu.nju.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.nju.dao.BaseDao;
import edu.nju.dao.StatisticsDao;
import edu.nju.model.PlanItem;
import edu.nju.model.RiskState;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.persistence.criteria.*;

@Repository
public class StatisticsDaoImpl implements StatisticsDao {

    @Autowired
    private BaseDao baseDao;

    @Override
    public List<Tuple> identifyMost(Date startTime, Date endTime) {
        return this.query(PlanItem.class, startTime, endTime);
    }

    @Override
    public List<Tuple> happenMost(Date startTime, Date endTime) {
        return this.query(RiskState.class, startTime, endTime);
    }

    private <T> List<Tuple> query(Class<T> type, Date startTime, Date endTime) {
        EntityManager em = this.baseDao.getEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();

        CriteriaQuery<Tuple> query = builder.createTupleQuery();

        Root<T> from = query.from(type);
        Path<Date> createTime = from.get("createTime");
        Path<Integer> rid = from.get("rid");

        Predicate condition = builder.between(createTime, startTime, endTime);
        Expression<Long> count = builder.count(from);

        query.where(condition);
        query.multiselect(rid, count);
        query.groupBy(rid);
        query.orderBy(builder.desc(count));

        return em.createQuery(query).setFirstResult(0).setMaxResults(10).getResultList();
    }
}
