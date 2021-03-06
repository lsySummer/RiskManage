package edu.nju.controller;

import edu.nju.model.RiskItem;
import edu.nju.model.RiskPlan;
import edu.nju.model.RiskState;
import edu.nju.model.User;
import edu.nju.service.RiskPlanService;
import edu.nju.service.RiskService;
import edu.nju.service.UserService;
import edu.nju.vo.RiskItemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Calendar;
import java.util.List;

@Controller
@RequestMapping("/risk/plan")
public class RiskPlanController extends BaseController {

    private final RiskPlanService riskPlanService;
    private final UserService userService;
    private final RiskService riskService;

    private static final String BASE_PATH = "/risk/plan/";
    private static final String REDIRECT_BASE_PATH = "redirect:" + BASE_PATH;

    private static final String PLAN_INFO = "planInfo";
    private static final String ITEM_INFO = "itemInfo";
    private static final String ITEMS = "items";
    private static final String USERS = "users";

    @Autowired
    public RiskPlanController(UserService userService, RiskPlanService riskPlanService, RiskService riskService) {
        this.userService = userService;
        this.riskPlanService = riskPlanService;
        this.riskService = riskService;
    }

    @RequestMapping("/")
    public ModelAndView list(@RequestParam(value = "type", defaultValue = "0") int type) {
        int id = this.getUser().getId();
        List<RiskPlan> plans;
        if (type == 0) {
            plans = this.riskPlanService.getSubmitPlans(id);
        } else {
            plans = this.riskPlanService.getFollowPlans(id);
        }
        return new ModelAndView("plan/list", "planList", plans).addObject("type", type);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String doCreate(RiskPlan plan) {
        plan.setUid(this.getUser().getId());

        this.riskPlanService.addRiskPlan(plan);

        return REDIRECT_BASE_PATH;
    }

    @RequestMapping("/{pid}")
    public ModelAndView detail(@PathVariable("pid") int pid, @RequestParam(value = "search", defaultValue = "") String keyword) {
        RiskPlan plan = this.riskPlanService.getById(pid);

        int userId = this.getUser().getId();
        boolean isCreator = (userId == plan.getUid());

        List<RiskItemVO> items;
        if (isCreator) {
            if (keyword.isEmpty()) {
                items = this.riskPlanService.showAll(pid);
            } else {
                items = this.riskPlanService.find(keyword, pid);
            }
        } else {
            if (keyword.isEmpty()) {
                items = this.riskPlanService.getFollowItem(userId, pid);
            } else {
                items = this.riskPlanService.find(keyword, pid, userId);
            }
        }

        return new ModelAndView("plan/detail", ITEMS, items)
                .addObject(PLAN_INFO, plan)
                .addObject("isCreator", isCreator);
    }

    @RequestMapping(value = "/{pid}/add_item", method = RequestMethod.GET)
    public ModelAndView addItem(@PathVariable("pid") int pid) {
        RiskPlan plan = this.riskPlanService.getById(pid);
        List<User> users = this.userService.showAll();
        return new ModelAndView("plan/addItem", PLAN_INFO, plan)
                .addObject(USERS, users);
    }

    @RequestMapping(value = "/{pid}/add_item", method = RequestMethod.POST)
    public String doAddItem(
            @PathVariable("pid") int pid,
            @RequestParam("follower") int follower,
            RiskItem item) {
        this.riskPlanService.itemAdd(item, pid, follower);

        return REDIRECT_BASE_PATH + pid;
    }

    @RequestMapping(value = "/{pid}/import_item", method = RequestMethod.GET)
    public ModelAndView importItem(@PathVariable("pid") int pid) {
        RiskPlan plan = this.riskPlanService.getById(pid);

        List<RiskItem> items = this.riskService.show();
        List<RiskItemVO> exists = this.riskPlanService.showAll(pid);
        items.removeAll(exists);

        List<User> users = this.userService.showAll();

        return new ModelAndView("/plan/importItem", PLAN_INFO, plan)
                .addObject(ITEMS, items)
                .addObject(USERS, users);
    }

    @RequestMapping(value = "/{pid}/import_item", method = RequestMethod.POST)
    public String doImportItem(
            @PathVariable("pid") int pid,
            @RequestParam("risk_id") int riskId,
            @RequestParam("follower") int followerId) {
        this.riskPlanService.importRisk(riskId, pid, followerId);

        return REDIRECT_BASE_PATH + pid;
    }

    @RequestMapping(value = "/{pid}/{rid}/modify", method = RequestMethod.GET)
    public ModelAndView modifyItem(@PathVariable("pid") int pid, @PathVariable("rid") int rid) {
        RiskPlan plan = this.riskPlanService.getById(pid);
        RiskItemVO item = this.riskPlanService.getRiskItem(pid, rid);
        List<User> users = this.userService.showAll();
        return new ModelAndView("/plan/modifyItem", PLAN_INFO, plan)
                .addObject(ITEM_INFO, item)
                .addObject(USERS, users);
    }

    @RequestMapping(value = "/{pid}/{rid}/modify", method = RequestMethod.POST)
    public String doModifyItem(
            @PathVariable("pid") int pid,
            @PathVariable("rid") int rid,
            @RequestParam("follower") int followerId,
            RiskItem item) {
        item.setId(rid);
        this.riskPlanService.itemModify(item, pid, followerId);
        return REDIRECT_BASE_PATH + pid;
    }

    @RequestMapping(value = "/{pid}/{rid}/remove", method = RequestMethod.POST)
    public String removeItem(@PathVariable("pid") int pid, @PathVariable("rid") int rid) {
        this.riskPlanService.itemDelete(rid, pid);
        return REDIRECT_BASE_PATH + pid;
    }

    @RequestMapping("/{pid}/{rid}")
    public ModelAndView itemStates(
            @PathVariable("pid") int pid,
            @PathVariable("rid") int rid) {
        List<RiskState> states = this.riskPlanService.getState(pid, rid);
        RiskPlan plan = this.riskPlanService.getById(pid);
        RiskItem risk = this.riskService.getById(rid);
        return new ModelAndView("plan/itemStates", "states", states)
                .addObject(PLAN_INFO, plan)
                .addObject(ITEM_INFO, risk);
    }

    @RequestMapping(value = "/{pid}/{rid}/add_state", method = RequestMethod.POST)
    public String addState(
            @PathVariable("pid") int pid,
            @PathVariable("rid") int rid,
            RiskState state) {
        state.setCreateTime(Calendar.getInstance().getTime());
        this.riskPlanService.addState(state);
        return REDIRECT_BASE_PATH + pid + "/" + rid;
    }
}
