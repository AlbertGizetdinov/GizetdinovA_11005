import java.util.ArrayList;
import java.util.NoSuchElementException;

class CRUDHolder<T extends Comparable<T> & Printable> {
        ArrayList<T> items = new ArrayList<>();

        public void create(T item) throws IllegalArgumentException {
            for (T x : items) {
                if (x.compareTo(item) == 0) {
                    throw new IllegalArgumentException("Illegal argument exception");
                }
            }

            items.add(item);
        }

        public T read(int id) throws NoSuchElementException {
            if (id >= items.size() || id < 0) {
                throw new IllegalArgumentException("Illegal argument exception");
            } else {
                return items.get(id);
            }
        }

        public void update(T item) throws NoSuchElementException {
            boolean bool = false;

            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).compareTo(item) == 0) {
                    items.set(i, item);
                    bool = true;
                }
            }

            if (!bool) {
                throw new IllegalArgumentException("Illegal argument exception");
            }
        }

        public void delete(T item) throws NoSuchElementException {
            if (!items.contains(item)) {
                throw new NoSuchElementException("No such element exception");
            }

            items.remove(item);
        }
    }
