package edu.nju.controller;

import edu.nju.model.RiskPlan;
import edu.nju.model.User;
import edu.nju.service.RiskPlanService;
import edu.nju.service.UserService;
import edu.nju.vo.RiskItemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/risk/plan")
public class RiskPlanController extends BaseController {

    private final RiskPlanService riskPlanService;

    private final UserService userService;

    @Autowired
    public RiskPlanController(UserService userService, RiskPlanService riskPlanService) {
        this.userService = userService;
        this.riskPlanService = riskPlanService;
    }

    @RequestMapping("/list")
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

    @RequestMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") int id) {
        List<RiskItemVO> items = this.riskPlanService.showAll(id);
        return new ModelAndView("plan/detail", "items", items);
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create() {
        List<User> users = this.userService.showAll();
        return new ModelAndView("plan/create", "users", users);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String doCreate(
            @RequestParam("plan_name") String planName,
            @RequestParam("project_name") String projectName,
            @RequestParam("follower") int followerId) {
        RiskPlan plan = new RiskPlan();
        plan.setPlanName(planName);
        plan.setProjectName(projectName);
        // TODO owner follower
        this.riskPlanService.addRiskPlan(plan);
        return "redirect:/risk/plan/list";
    }
}
