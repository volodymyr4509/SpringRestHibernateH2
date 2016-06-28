package controller;

import dto.Typicode;
import manager.TypicodeManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by volodymyr on 28.06.16.
 */

@Controller
public class TestController {
    private TypicodeManager manager = new TypicodeManager();

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String testGet(Model model) {
        System.out.println("TestController GET");
        reloadModel(model);
        return "test";
    }


    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String testPost(@ModelAttribute Typicode typicode, Model model) {
        System.out.println("TestController POST");

        manager.handleInput(typicode.getId());
        reloadModel(model);
        return "test";
    }

    private void reloadModel(Model model) {
        List<Typicode> typicodeList = manager.getTypicodeList();
        model.addAttribute("typicode", new Typicode());
        model.addAttribute("typicodeList", typicodeList);
    }

}
