package stepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.Cart;
import pageObject.Tees;

import java.io.IOException;

public class AddItemToCart {
    @When("user hovers over the product name,selects a size and color for the product")
    public void user_hovers_over_the_product_name_selects_a_size_and_color_for_the_product() {
        Tees.heroHoodie();
    }
    @Then("product is added to cart")
    public void product_is_added_to_cart() throws IOException {
        Cart.heroHoodieCartButton();
    }
}
