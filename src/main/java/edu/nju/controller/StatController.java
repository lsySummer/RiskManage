package edu.nju.controller;

import edu.nju.service.StatisticsService;
import edu.nju.vo.StatVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/risk/stat")
public class StatController {
    private final StatisticsService statService;

    @Autowired
    public StatController(StatisticsService statService) {
        this.statService = statService;
    }

    @RequestMapping("/")
    public ModelAndView display() {
        Calendar c = Calendar.getInstance();
        Date today = c.getTime();
        c.add(Calendar.MONTH, -1);
        Date oneMonthAgo = c.getTime();
        return new ModelAndView("stat/display", "from", oneMonthAgo).addObject("to", today);
    }

    @RequestMapping("/get")
    @ResponseBody
    public List<StatVO> identifyMost(
            @RequestParam("type") String type,
            @RequestParam(value = "from", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date from,
            @RequestParam(value = "to", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date to) {
        if (from == null || to == null) {
            return new ArrayList<>();
        }

        Calendar c = Calendar.getInstance();
        c.setTime(to);
        c.add(Calendar.DATE, 1);
        to = c.getTime();
        if ("identify".equals(type)) {
            return this.statService.identifyMost(from, to);
        } else {
            return this.statService.happenMost(from, to);
        }
    }
}
