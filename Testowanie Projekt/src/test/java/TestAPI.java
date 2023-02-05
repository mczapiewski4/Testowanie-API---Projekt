import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;


public class TestAPI {

    @Test
    public void fetchingCards() {
        RestAssured.given().when().get("https://api.magicthegathering.io/v1/cards")
                .then().assertThat().statusCode(200);
    }

    @Test
    public void cardFilteringByName() {
        String nameValue = "Archangel Avacyn // Avacyn, the Purifier";

        RestAssured.given().queryParam("name", nameValue).when().get("https://api.magicthegathering.io/v1/cards")
                .then().assertThat().statusCode(200).body("cards.name", Matchers.everyItem(Matchers.equalTo(nameValue)));

    }

    @Test
    public void cardFilteringByLayout() {
        String layoutValue = "double-faced";

        RestAssured.given().queryParam("layout", layoutValue).when().get("https://api.magicthegathering.io/v1/cards")
                .then().assertThat().statusCode(200).body("cards.layout", Matchers.everyItem(Matchers.contains(layoutValue)));

    }

    @Test
    public void cardFilteringByCmc() {
        String cmcValue = "5";

        RestAssured.given().queryParam("cmc", cmcValue).when().get("https://api.magicthegathering.io/v1/cards")
                .then().assertThat().statusCode(200).body("cards.cmc", Matchers.everyItem(Matchers.equalTo((float) 5)));

    }

    @Test
    public void cardFilteringByColors() {
        String colorValue = "White";

        RestAssured.given().queryParam("colors", colorValue).when().get("https://api.magicthegathering.io/v1/cards").
                then().assertThat().statusCode(200).body("cards.colors", Matchers.everyItem(Matchers.hasItems(colorValue)));

    }

    @Test
    public void cardFilteringByColorIdentity() {
        String colorIdentityValue = "W";

        RestAssured.given().queryParam("colorIdentity", colorIdentityValue).when().get("https://api.magicthegathering.io/v1/cards")
                .then().assertThat().statusCode(200).body("cards.colorIdentity", Matchers.everyItem(Matchers.hasItems(colorIdentityValue)));
    }

    @Test
    public void cardFilteringByType() {
        String typeValue = "Legendary Creature — Angel";

        RestAssured.given().queryParam("type", typeValue).when().get("https://api.magicthegathering.io/v1/cards")
                .then().assertThat().statusCode(200).body("cards.type", Matchers.everyItem(Matchers.stringContainsInOrder(typeValue)));

    }

    @Test
    public void cardFilteringBySupertypes() {
        String supertypeValue = "Legendary";

        RestAssured.given().queryParam("supertypes", supertypeValue).when().get("https://api.magicthegathering.io/v1/cards")
                .then().assertThat().statusCode(200).body("cards.supertypes", Matchers.everyItem(Matchers.hasItems(supertypeValue)));

    }

    @Test
    public void cardFilteringByTypes() {
        String typesValue = "Creature";

        RestAssured.given().queryParam("types", typesValue).when().get("https://api.magicthegathering.io/v1/cards")
                .then().assertThat().statusCode(200).body("cards.types", Matchers.everyItem(Matchers.hasItems(typesValue)));

    }

    @Test
    public void cardFilteringBySubtypes() {
        String subtypesValue = "Angel";

        RestAssured.given().queryParam("subtypes", subtypesValue).when().get("https://api.magicthegathering.io/v1/cards")
                .then().assertThat().statusCode(200).body("cards.subtypes", Matchers.everyItem(Matchers.hasItems(subtypesValue)));

    }

    @Test
    public void cardFilteringByRarity() {
        String rarityValue = "Mythic Rare";

        RestAssured.given().queryParam("rarity", rarityValue).when().get("https://api.magicthegathering.io/v1/cards")
                .then().assertThat().statusCode(200).body("cards.rarity", Matchers.everyItem(Matchers.equalTo(rarityValue)));

    }

    @Test
    public void cardFilteringBySet() {
        String setValue = "SOI";

        RestAssured.given().queryParam("set", setValue).when().get("https://api.magicthegathering.io/v1/cards")
                .then().assertThat().statusCode(200).body("cards.set", Matchers.everyItem(Matchers.equalTo(setValue)));

    }

    @Test
    public void cardFilteringBySetName() {
        String setNameValue = "Tenth Edition";

        RestAssured.given().queryParam("setName", setNameValue).when().get("https://api.magicthegathering.io/v1/cards")
                .then().assertThat().statusCode(200).body("cards.setName", Matchers.everyItem(Matchers.equalTo(setNameValue)));

    }

    @Test
    public void cardFilteringByText() {
        String textValue = "Flash Flying, vigilance When Archangel Avacyn enters the battlefield, creatures you control gain indestructible until end of turn. When a non-Angel creature you control dies, transform Archangel Avacyn at the beginning of the next upkeep.";

        RestAssured.given().queryParam("text", textValue).when().get("https://api.magicthegathering.io/v1/cards")
                .then().assertThat().statusCode(200).body("cards.text", Matchers.everyItem(Matchers.equalTo(textValue)));

    }

    @Test
    public void cardFilteringByFlavor() {
        String flavorValue = "„Es ist der Wille aller, und meine Hand, die ihn ausführt.\"";

        RestAssured.given().queryParam("flavor", flavorValue).when().get("https://api.magicthegathering.io/v1/cards")
                .then().assertThat().statusCode(200).body("cards.foreignNames.flavor", Matchers.everyItem(Matchers.hasItems(flavorValue)));
    }

    @Test
    public void cardFilteringByArtist() {
        String artistValue = "James Ryman";

        RestAssured.given().queryParam("artist", artistValue).when().get("https://api.magicthegathering.io/v1/cards")
                .then().assertThat().statusCode(200).body("cards.artist", Matchers.everyItem(Matchers.equalTo(artistValue)));

    }

    @Test
    public void cardFilteringByNumber() {
        String numberValue = "5a";

        RestAssured.given().queryParam("number", numberValue).when().get("https://api.magicthegathering.io/v1/cards")
                .then().assertThat().statusCode(200).body("cards.number", Matchers.everyItem(Matchers.equalTo(numberValue)));

    }

    @Test
    public void cardFilteringByPower() {
        String powerValue = "4";

        RestAssured.given().queryParam("power", powerValue).when().get("https://api.magicthegathering.io/v1/cards")
                .then().assertThat().statusCode(200).body("cards.power", Matchers.everyItem(Matchers.equalTo(powerValue)));

    }

    @Test
    public void cardFilteringByToughness() {
        String toughnessValue = "4";

        RestAssured.given().queryParam("toughness", toughnessValue).when().get("https://api.magicthegathering.io/v1/cards")
                .then().assertThat().statusCode(200).body("cards.toughness", Matchers.everyItem(Matchers.equalTo(toughnessValue)));

    }

    @Test
    public void cardFilteringByLoyalty() {
        String loyaltyValue = "4";

        RestAssured.given().queryParam("loyalty", loyaltyValue).when().get("https://api.magicthegathering.io/v1/cards")
                .then().assertThat().statusCode(200).body("cards.loyalty", Matchers.everyItem(Matchers.equalTo(loyaltyValue)));

    }

    @Test
    public void cardFilteringByLanguage() {
        String languageValue = "Chinese Simplified";

        RestAssured.given().queryParam("language", languageValue).when().get("https://api.magicthegathering.io/v1/cards")
                .then().assertThat().statusCode(200).body("cards.foreignNames.language", Matchers.everyItem(Matchers.hasItems(languageValue)));
    }

    @Test
    public void cardFilteringByLegality() {
        String legalityValue = "Legal";

        RestAssured.given().queryParam("legality", legalityValue).when().get("https://api.magicthegathering.io/v1/cards")
                .then().assertThat().statusCode(200).body("cards.legalities.legality", Matchers.everyItem(Matchers.hasItems(legalityValue)));
    }

    @Test
    public void applyingPageToRequest() {
        int pageValue = 1;

        RestAssured.given().queryParam("page", pageValue).when().get("https://api.magicthegathering.io/v1/cards")
                .then().assertThat().statusCode(200);
    }

    @Test
    public void applyingPageToRequest2() {
        int pageValue = -99999999;

        RestAssured.given().queryParam("page", pageValue).when().get("https://api.magicthegathering.io/v1/cards")
                .then().assertThat().statusCode(400);

    }

    @Test
    public void applyingPageSizeToRequest() {
        int pageSizeValue = 1;

        RestAssured.given().queryParam("pageSize", pageSizeValue).when().get("https://api.magicthegathering.io/v1/cards")
                .then().assertThat().statusCode(200);
    }

    @Test
    public void applyingPageSizeToRequest2() {
        int pageSizeValue = -3;

        RestAssured.given().queryParam("page", pageSizeValue).when().get("https://api.magicthegathering.io/v1/cards")
                .then().assertThat().statusCode(400);
    }

    @Test
    public void applyingRandomToRequest() {
        RestAssured.given().queryParam("random").when().get("https://api.magicthegathering.io/v1/cards")
                .then().assertThat().statusCode(200);
    }

    @Test
    public void applyingContainsToRequest() {
        RestAssured.given().queryParam("Matchers.contains", "name").when().get("https://api.magicthegathering.io/v1/cards")
                .then().assertThat().statusCode(200);
        Assert.assertNotEquals("{\"cards\":[]}", RestAssured.given().queryParam("contains", "name").when()
                .get("https://api.magicthegathering.io/v1/cards").getBody().toString());
    }

    @Test
    public void cardFilteringById() {
        String idValue = "668c64a2-cecb-5f48-af16-d7a64814d3e7";

        RestAssured.given().queryParam("id", idValue).when().get("https://api.magicthegathering.io/v1/cards")
                .then().assertThat().statusCode(200).body("cards.id", Matchers.everyItem(Matchers.equalTo(idValue)));
    }

    @Test
    public void cardFilteringByMultiverseid() {
        String multiverseidValue = "409741";

        RestAssured.given().queryParam("multiverseid", multiverseidValue).when().get("https://api.magicthegathering.io/v1/cards")
                .then().assertThat().statusCode(200).body("cards.multiverseid", Matchers.everyItem(Matchers.equalTo(multiverseidValue)));
    }

    /////////

    @Test
    public void fetchingCardById() {
        String idValue = "5f8287b1-5bb6-5f4c-ad17-316a40d5bb0c";

        RestAssured.given().when().get("https://api.magicthegathering.io/v1/cards" + "/" + idValue)
                .then().assertThat().statusCode(200).body("card.id", Matchers.is(idValue));
    }

    @Test
    public void fetchingCardById2() {
        String idValue = null;

        RestAssured.given().when().get("https://api.magicthegathering.io/v1/cards" + "/" + idValue)
                .then().assertThat().statusCode(404).body("card.id", Matchers.is(idValue));
    }

    ////////

    @Test
    public void fetchingSets() {
        RestAssured.given().when().get("https://api.magicthegathering.io/v1/sets")
                .then().assertThat().statusCode(200);
    }

    @Test
    public void setsFilteringByName() {
        String nameValue = "Khans of Tarkir";

        RestAssured.given().queryParam("name", nameValue).when().get("https://api.magicthegathering.io/v1/sets")
                .then().assertThat().statusCode(200).body("sets.name", Matchers.everyItem(Matchers.stringContainsInOrder(nameValue)));
    }

    ////////

    @Test
    public void fetchingSetByPage() {
        int pageValue = 2;
        int pageSizeValue = 10;

        RestAssured.given().when().get("https://api.magicthegathering.io/v1/sets" + "?page=" + pageValue + "pageSize=" + pageSizeValue)
                .then().assertThat().statusCode(200);
    }

    //////////

    @Test
    public void fetchingSetsByCode() {
        String codeValue = "KTK";

        RestAssured.given().when().get("https://api.magicthegathering.io/v1/sets" + "/" + codeValue)
                .then().assertThat().statusCode(200).body("set.code", is(codeValue));
    }

    //////////

    @Test
    public void fetchingTypes() {
        RestAssured.given().when().get("https://api.magicthegathering.io/v1/types")
                .then().assertThat().statusCode(200);
    }

    /////////

    @Test
    public void fetchingSubtypes() {
        RestAssured.given().when().get("https://api.magicthegathering.io/v1/subtypes")
                .then().assertThat().statusCode(200);
    }

    ////////

    @Test
    public void fetchingSupertypes() {
        RestAssured.given().when().get("https://api.magicthegathering.io/v1/supertypes")
                .then().assertThat().statusCode(200);
    }

    //////

    @Test
    public void fetchingFormats() {
        RestAssured.given().when().get("https://api.magicthegathering.io/v1/formats")
                .then().assertThat().statusCode(200);
    }
}
