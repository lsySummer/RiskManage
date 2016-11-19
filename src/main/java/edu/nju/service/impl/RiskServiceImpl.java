package edu.nju.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.nju.dao.RiskDao;
import edu.nju.model.RiskItem;
import edu.nju.service.RiskService;

@Service
public class RiskServiceImpl implements RiskService {

	@Autowired
	private RiskDao riskDao;

	@Override
	public List<RiskItem> show() {
		return riskDao.show();
	}

	@Override
	public RiskItem getById(int rid) {
		return riskDao.getItemById(rid);
	};
}
