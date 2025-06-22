package ecommerce;

import java.util.*;
public class Ecommerce {
    static class Item {
        int itemId;
        String itemName;
        String itemCategory;

        Item(int itemId, String itemName, String itemCategory) {
            this.itemId = itemId;
            this.itemName = itemName;
            this.itemCategory = itemCategory;
        }
    }
    
    //Linear Search
    static class LinearItemSearch {
        public long performLinearSearch(Item[] items, String keyword) {
            System.out.println("Linear Search");
            long startTime = System.nanoTime();
            boolean found = false;

            for (Item item : items) {
                if (item.itemName.equalsIgnoreCase(keyword)) {
                    System.out.println("Item Found: " + item.itemName + " (" + item.itemCategory + ")");
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Item Not Found");
            }

            long endTime = System.nanoTime();
            return endTime - startTime;
        }
    }
    
    //Binary Search
    static class BinaryItemSearch {
        public long performBinarySearch(Item[] items, String keyword) {
            System.out.println("Binary Search");

            Arrays.sort(items, new Comparator<Item>() {
                public int compare(Item i1, Item i2) {
                    return i1.itemName.compareToIgnoreCase(i2.itemName);
                }
            });
            long startTime = System.nanoTime();
            boolean found = false;
            int left = 0, right = items.length - 1;

            while (left <= right) {
                int mid = (left + right) / 2;
                String name = items[mid].itemName;
                int cmp = name.compareToIgnoreCase(keyword);

                if (cmp == 0) {
                    System.out.println("Item Found: " + items[mid].itemName + " (" + items[mid].itemCategory + ")");
                    found = true;
                    break;
                } else if (cmp < 0) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            if (!found) {
                System.out.println("Item Not Found");
            }

            long endTime = System.nanoTime();
            return endTime - startTime;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Item[] items = {
            new Item(101, "iPhone", "Electronics"),
            new Item(102, "GalaxyWatch", "Wearables"),
            new Item(103, "MacBook", "Electronics"),
            new Item(104, "OfficeChair", "Furniture"),
            new Item(105, "RunningShoes", "Footwear"),
            new Item(106, "BluetoothSpeaker", "Electronics"),
            new Item(107, "CookwareSet", "HomeAppliances"),
            new Item(108, "DSLR", "Camera"),
            new Item(109, "Backpack", "Bags"),
            new Item(110, "WaterBottle", "Accessories")
        };
        System.out.println("Enter the item name to search:");
        String keyword = sc.nextLine();
        System.out.println();
        LinearItemSearch linear = new LinearItemSearch();
        long linearTime = linear.performLinearSearch(items, keyword);
        System.out.println();
        BinaryItemSearch binary = new BinaryItemSearch();
        long binaryTime = binary.performBinarySearch(items, keyword);
        System.out.println();
        System.out.println("Linear Search Time: " + linearTime);
        System.out.println("Binary Search Time: " + binaryTime);
        sc.close();
    }
}
