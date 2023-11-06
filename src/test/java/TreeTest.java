import static org.junit.jupiter.api.Assertions.*;
import org.example.Tree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class TreeTest {

    private Tree<Integer> tree;

    @BeforeEach
    public void setUp() {
        tree = new Tree<>();
    }

    @Test
    public void testInsertSingleNode() {
        tree.Insert(5);
        assertEquals(5, tree.getRoot().getData());
        assertNull(tree.getRoot().getLeft());
        assertNull(tree.getRoot().getRight());
    }

    @Test
    public void testInsertMultipleNodes() {
        tree.Insert(5);
        tree.Insert(3);
        tree.Insert(7);
        assertEquals(5, tree.getRoot().getData());
        assertEquals(3, tree.getRoot().getLeft().getData());
        assertEquals(7, tree.getRoot().getRight().getData());
    }

    @Test
    public void testInsertDuplicateNode() {
        tree.Insert(5);
        tree.Insert(5);
        assertEquals(5, tree.getRoot().getData());
        assertNull(tree.getRoot().getLeft());
        assertNull(tree.getRoot().getRight());
    }

    @Test
    public void testInsertList() {
        tree.Insert(Arrays.asList(5, 3, 7));
        assertEquals(5, tree.getRoot().getData());
        assertEquals(3, tree.getRoot().getLeft().getData());
        assertEquals(7, tree.getRoot().getRight().getData());
    }

    @Test
    public void testTreeStructure() {
        tree.Insert(Arrays.asList(5, 3, 7, 2, 4, 6, 8));
        assertEquals(5, tree.getRoot().getData());
        assertEquals(3, tree.getRoot().getLeft().getData());
        assertEquals(2, tree.getRoot().getLeft().getLeft().getData());
        assertEquals(4, tree.getRoot().getLeft().getRight().getData());
        assertEquals(7, tree.getRoot().getRight().getData());
        assertEquals(6, tree.getRoot().getRight().getLeft().getData());
        assertEquals(8, tree.getRoot().getRight().getRight().getData());
    }

}
