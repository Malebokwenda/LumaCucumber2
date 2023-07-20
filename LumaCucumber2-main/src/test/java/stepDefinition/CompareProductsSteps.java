package stepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.CompareProducts;
import pageObject.Validation;

import java.io.IOException;

public class CompareProductsSteps {
        @When("user scrolls down to view products under Hot Sellers")
        public void user_scrolls_down_to_view_products_under_hot_sellers() {
            CompareProducts.scrollToHotSellers();
        }

        @When("user hover over the product name to add to compare")
        public void user_hover_over_the_product_name_to_add_to_compare() throws IOException, InterruptedException {
            CompareProducts.HoverToClickCompareIcon();
        }
        @When("user clicks on product name to add to compare product")
        public void user_clicks_on_product_name_to_add_to_compare_product() throws IOException, InterruptedException {
            CompareProducts.compareOnImgClicked();
    }

        @When("user clicks on the comparison list link in the confirmation message")
        public void user_clicks_on_the_comparison_list_link_in_the_confirmation_message() throws IOException, InterruptedException {
            CompareProducts.compareListLink();
        }

        @Then("user should see a confirmation message")
        public void user_should_see_a_confirmation_message() throws IOException {
            Validation.compareSuccessText();
        }


        @When("user see a confirmation message")
        public void user_see_a_confirmation_message() {
            // Write code here that turns the phrase above into concrete actions
            throw new io.cucumber.java.PendingException();
        }

        @Then("user should be redirected to the comparison list page")
        public void user_should_be_redirected_to_the_comparison_list_page() {
            CompareProducts.compareProducts();
        }

        @When("user clicks on the product name to add product to compare product")
        public void user_clicks_on_the_product_name_to_add_product_to_compare_product() {
            CompareProducts.weatherTankProduct();
        }

        @When("user clicks on the remove icon for product name")
        public void user_clicks_on_the_remove_icon_for_product_name() throws IOException, InterruptedException {
            CompareProducts.removeComparedItem();
        }
        @When("user select OK from the confirmation alert")
        public void user_select_ok_from_the_confirmation_alert() throws InterruptedException {
            CompareProducts.okAlertButton();
        }
        @Then("the product name should be successfully removed from the comparison list")
        public void the_product_name_should_be_successfully_removed_from_the_comparison_list() throws IOException {
            Validation.removedItemText();
        }


    }
