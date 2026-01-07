package school.hei;


public class Main {
    public static void main(String[] args) {
        DataRetriever retriever = new DataRetriever();

        System.out.println("=== Test récupération plat et calcul coût ===");
        try {
            Dish dish = retriever.findDishById(1);
            if (dish == null) {
                System.out.println("Plat non trouvé");
            } else {
                System.out.println(dish);
                System.out.println("Coût du plat : " + dish.getDishCost() + " Ar");
            }
        } catch (RuntimeException e) {
            System.out.println("ERREUR : " + e.getMessage());
        }



        System.out.println("\n=== Test sauvegarde plat et modification prix de vente ===");
        Dish dishToSave = new Dish();
        dishToSave.setId(1);
        dishToSave.setName("Mon super plat");
        dishToSave.setSellingPrice(22000.0);

        Dish savedDish = Dish.saveDish(dishToSave);

        System.out.println("Plat sauvegardé : " + savedDish);
        System.out.println("Nouveau prix de vente : " + savedDish.getSellingPrice() + " Ar");

        try {
            System.out.println("Coût après sauvegarde : " + savedDish.getDishCost() + " Ar");
        } catch (RuntimeException e) {
            System.out.println("ERREUR coût : " + e.getMessage());
        }

    }
}