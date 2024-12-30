package Tests;

import Pages.CategoriesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Categories extends TestBase {


        @Test
        public void testCategoriesHeaderIsDisplayed() {
            CategoriesPage categories =new CategoriesPage(driver);
            Assert.assertTrue(categories.isCategoriesHeaderDisplayed(), "Categories header is not displayed!");
        }

        @Test
        public void testPhonesCategoryItems() {
            CategoriesPage categories=new CategoriesPage(driver);
            categories.clickCategory("Phones");
            Assert.assertFalse(categories.getCategoryItems().isEmpty(), "No items found in Phones category!");
        }

        @Test
        public void testLaptopsCategoryItems() {
            CategoriesPage categories=new CategoriesPage(driver);
            categories.clickCategory("Laptops");
            Assert.assertFalse(categories.getCategoryItems().isEmpty(), "No items found in Laptops category!");
        }

        @Test
        public void testMonitorsCategoryItems() {
            CategoriesPage categoriesPage=new CategoriesPage(driver);
            categoriesPage.clickCategory("Monitors");
            Assert.assertFalse(categoriesPage.getCategoryItems().isEmpty(), "No items found in Monitors category!");
        }

        @Test
        public void testItemsSize() {
            CategoriesPage categoriesPage=new CategoriesPage(driver);
            //categoriesPage.clickCategory("Monitors");
            Assert.assertEquals(categoriesPage.getItemsTitle().size(), 9);
        }

    @Test
    public void testElementContent() {
        CategoriesPage categoriesPage=new CategoriesPage(driver);
        //categoriesPage.clickCategory("Monitors");
        Assert.assertEquals(categoriesPage.getItemsElements().get(0).getText(), "Samsung galaxy s6");
    }


    }




