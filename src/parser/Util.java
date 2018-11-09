package parser;

import entity.SportInv;
import entity.SportShop;
import entity.Category;

/**
 * Created by iryna.subota on 12.02.2017.
 */

public class Util {

	public static SportShop createSportShop() {
    	SportShop sportShop = new SportShop();
        SportInv sportinv = new SportInv();
        sportShop.addSportInv(sportinv);
        sportinv.setId(3);
        sportinv.setName("Тренажер 'Spartacus'");
        sportinv.setCompany("SUPER");
        sportinv.setDescription("Тренажер 'Spartacus' – отличное решение для домашних тренировок на растяжку. Модель при правильном использовании выдерживает неограниченную нагрузку, не имеет ограничений по полу и возрасту. Длина в сложенном состоянии - 105 см.");
        sportinv.setPrice(890.0);
        sportinv.setCategory(Category.FITNESS_AND_AEROBICS);
        sportinv.setCodeTovars("000011");
        return sportShop;
    }
}
