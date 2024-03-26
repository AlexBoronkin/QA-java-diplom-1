package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Random;

@RunWith(Parameterized.class)
public class BunTest {

    private final String name;
    private final float price;


    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    //Дальше использую параметризацию для разных проверок.Так как нет описания полей, данные подбираю на глаз по техникам тест дизайна

    @Parameterized.Parameters
    public static Object[][] buns() {
        return new Object[][] {
                {"Флюоресцентная булка R2-D3", 988.00f},
                {"Краторная булка N-200i", 1255},
                {"Булка5", 345.055f},
                {"R", new Random().nextFloat()},
                {"", new Random().nextFloat()},
                {" ", new Random().nextFloat()},
                {"!@$#%^%$&^][[][,.,;)(*&", new Random().nextFloat()},
                {"Флюоресцентная булка R2-D3", -123},
                {"Флюоресцентная булка R2-D3", 0},
                {"Флюоресцентная булка R2-D3", 4/9},
                {"Флюоресцентная булка R2-D3", 465743443},

        };
    }

    @Test
    public void nameTest() {
        Bun bun = new Bun(name,price);
        Assert.assertEquals(name, bun.getName());
    }

    @Test
    public void priceTest() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals(price, bun.getPrice(),0);
    }

}
