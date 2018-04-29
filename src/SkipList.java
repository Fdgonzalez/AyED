public class SkipList<T extends Comparable<? super T>> {
    private Node<T> head;

    public boolean contains(T elem){
        if(isEmpty())
            return false;
        int level = head.h;
        Node<T> aux = head;
        while(aux.levels[0] != null){
            int c;
            if(aux.levels[level-1] == null || ( c = aux.levels[level-1].elem.compareTo(elem)) > 0){//si apunto a null o apunto a un mayor a elem
                level--;//bajo un nivel (sigo en el mismo nodo)
                if(level == 0)
                    return false;
            }else if(c < 0){//si apunto a un menor a mi elemento
                aux = aux.levels[level-1];
                level = aux.h;
            }else
                return true;
        }
        return false;
    }

    private boolean isEmpty() {
        return head == null;
    }

    private static class Node<T> {
        T elem;
        int h;
        Node<T>[] levels;
    }
}
