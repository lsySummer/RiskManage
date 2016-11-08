package edu.nju.dao;

import java.util.List;

import edu.nju.model.RiskItem;
import edu.nju.model.RiskState;

public interface RiskDao {

	public boolean add(RiskItem risk);

	public boolean delete(int id);

	public boolean modify(RiskItem risk);

	public List<RiskItem> show();

	public List<RiskItem> find(String keyword);

	public boolean addState(RiskState state);

	public List<RiskState> getAllState();

	public RiskState getStateById(int id);

}
