import java.util.Comparator;

/*
* 对于一颗二叉搜索树, 添加新的子节点(childNode), 一定不会使新子节点的父节点(parentNode)失衡. 如果有节点失衡,一定是新子节点的祖先节点(grandNode)失衡. 父节点的兄弟节点和祖先节点的兄弟节点一定不会失衡.
* 因为当一个节点, 那么添加childNode之前 parentNode的度一定是1/0;
* 如果parentNode的度是0, 新增 childNode一定不会导致失衡
* 如果parentNode的度是1, 新增 childNode只会使parentNode的度变为2, 更不会失衡.
* 所谓的左旋右旋其实就是为了找到失衡的节点g, 然后查找g的子节点f, g的孙子节点n, 然后找到三个节点中的中间值得节点, 然后左子树为较小的节点, 右子树为较大的节点.
* */

public class AVLTree<E> extends BSTree <E>{
    public AVLTree(){
        this(null);
    }
    public AVLTree(Comparator<E> comparator) {
        super(comparator);
    }

    @Override
    protected AVLNode<E> initNode(E element, Node<E> parent) {
        return new AVLNode<>(element, parent);
    }

    @Override
    protected void afterAdd(BSTree.Node<E> node) {
        while ((node = node.parent) != null)
            if (node.is){

            }else{

            }
    }


    private static class AVLNode <E> extends Node<E>{
        int height = 1;
        public AVLNode(E element, Node<E> parent) {
            super(element, parent);
        }
    }
}
