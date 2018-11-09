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
        sportinv.setName("�������� 'Spartacus'");
        sportinv.setCompany("SUPER");
        sportinv.setDescription("�������� 'Spartacus' � �������� ������� ��� �������� ���������� �� ��������. ������ ��� ���������� ������������� ����������� �������������� ��������, �� ����� ����������� �� ���� � ��������. ����� � ��������� ��������� - 105 ��.");
        sportinv.setPrice(890.0);
        sportinv.setCategory(Category.FITNESS_AND_AEROBICS);
        sportinv.setCodeTovars("000011");
        return sportShop;
    }
}
