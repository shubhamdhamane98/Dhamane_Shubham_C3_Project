import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();

    public Restaurant findRestaurantByName(String RESTAURANT_NAME) throws restaurantNotFoundException {
        for (Restaurant record: restaurants) {
            if(record.getName().equals(RESTAURANT_NAME))
                return record;
            else
                throw new restaurantNotFoundException("Restaurant Not Found");
        }
        return null;
    }


    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        restaurants.remove(restaurantToBeRemoved);
        return restaurantToBeRemoved;
    }

    public int getTotalCostOfItems(List<Item> items)
    {
        int total_cost = 0;
        for (Item singleItem: items) {
            total_cost += singleItem.getPrice();
        }

        return total_cost;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
}
