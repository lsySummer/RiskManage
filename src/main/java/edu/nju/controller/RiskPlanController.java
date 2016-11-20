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

import java.util.List;

@Controller
@RequestMapping("/risk/plan")
public class RiskPlanController extends BaseController {

    private final RiskPlanService riskPlanService;

    private final UserService userService;

    private final RiskService riskService;

    private static final String planInfoField = "planInfo";

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

        return "redirect:/risk/plan/";
    }

    @RequestMapping("/{pid}")
    public ModelAndView detail(@PathVariable("pid") int pid) {
        RiskPlan plan = this.riskPlanService.getById(pid);

        int userId = this.getUser().getId();
        boolean isCreator = (userId == plan.getUid());

        List<RiskItemVO> items;
        if (isCreator) {
            items = this.riskPlanService.showAll(pid);
        } else {
            items = this.riskPlanService.getFollowItem(userId, pid);
        }

        return new ModelAndView("plan/detail", "items", items)
                .addObject(planInfoField, plan)
                .addObject("isCreator", isCreator);
    }

    @RequestMapping(value = "/{pid}/add_item", method = RequestMethod.GET)
    public ModelAndView addItem(@PathVariable("pid") int pid) {
        RiskPlan plan = this.riskPlanService.getById(pid);
        List<User> users = this.userService.showAll();
        return new ModelAndView("plan/addItem", planInfoField, plan)
                .addObject("users", users);
    }

    @RequestMapping(value = "/{pid}/add_item", method = RequestMethod.POST)
    public String doAddItem(
            @PathVariable("pid") int pid,
            @RequestParam("follower") int follower,
            RiskItem item) {
        this.riskPlanService.itemAdd(item, pid, follower);

        return "redirect:/risk/plan/" + pid;
    }

    @RequestMapping(value = "/{pid}/import_item", method = RequestMethod.GET)
    public ModelAndView importItem(@PathVariable("pid") int pid) {
        RiskPlan plan = this.riskPlanService.getById(pid);
        List<RiskItem> items = this.riskService.show();
        List<User> users = this.userService.showAll();

        return new ModelAndView("/plan/importItem", planInfoField, plan)
                .addObject("items", items)
                .addObject("users", users);
    }

    @RequestMapping(value = "/{id}/import_item", method = RequestMethod.POST)
    public String doImportItem(
            @PathVariable("id") int pid,
            @RequestParam("risk_id") int riskId,
            @RequestParam("follower") int followerId) {
        this.riskPlanService.importRisk(riskId, pid, followerId);

        return "redirect:/risk/plan/" + pid;
    }

    @RequestMapping(value = "/{pid}/{rid}")
    public ModelAndView itemStates(
            @PathVariable("pid") int pid,
            @PathVariable("rid") int rid) {
        List<RiskState> states = this.riskPlanService.getState(pid, rid);
        RiskPlan plan = this.riskPlanService.getById(pid);
        return new ModelAndView("plan/itemStates", "states", states)
                .addObject(planInfoField, plan);
    }
}
