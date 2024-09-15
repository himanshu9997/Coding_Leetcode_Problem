class RandomizedSet {
    private HashMap<Integer, Integer> valueToIndex;
    private ArrayList<Integer> values;
    private Random rand;

    public RandomizedSet() {
        valueToIndex = new HashMap<>();
        values = new ArrayList<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (valueToIndex.containsKey(val)) {
            return false;
        }

        valueToIndex.put(val, values.size());
        values.add(val);

        return true;
    }

    public boolean remove(int val) {
        if (!valueToIndex.containsKey(val)) {
            return false;
        }

        int indexToRemove = valueToIndex.get(val);
        int lastElement = values.get(values.size() - 1);

        values.set(indexToRemove, lastElement);
        valueToIndex.put(lastElement, indexToRemove);

        values.remove(values.size() - 1);
        valueToIndex.remove(val);

        return true;
    }

    public int getRandom() {
        int randomIndex = rand.nextInt(values.size());
        return values.get(randomIndex);
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(1));
        System.out.println(randomizedSet.remove(2)); 
        System.out.println(randomizedSet.insert(2)); 
        System.out.println(randomizedSet.getRandom()); 
        System.out.println(randomizedSet.remove(1)); 
        System.out.println(randomizedSet.insert(2)); 
        System.out.println(randomizedSet.getRandom()); 
    }
}
