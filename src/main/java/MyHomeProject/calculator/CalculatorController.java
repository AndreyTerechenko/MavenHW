package MyHomeProject.calculator;

import MyHomeProject.calculator.Service.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/Calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String startMessage() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("/plus")
    public String plus(@RequestParam int num1, @RequestParam int num2) {
        return num1 + "+" + num2 + "=" + calculatorService.plus(num1, num2);
    }

    @GetMapping("/minus")
    public String minus(int num1, int num2) {
        return num1 + "-" + num2 + "=" + calculatorService.minus(num1, num2);
    }

    @GetMapping("/multiply")
    public String multiply(int num1, int num2) {
        return num1 + "*" + num2 + "=" + calculatorService.multiply(num1, num2);
    }

    @GetMapping("/divide")
    public String divide(int num1, int num2) {
        if (num2 == 0) {
            return "Делить на 0 нельзя!";
        }
        return num1 + "/" + num2 + "=" + calculatorService.divide(num1, num2);
    }

}
