package pl.recruitment.rtg.utils;

import javafx.scene.Node;
import javafx.scene.shape.Circle;
import org.assertj.core.api.Assertions;
import org.junit.Test;
public class DraggableTest {

    private Draggable.Nature draggable;

    @Test
    public void shouldAddNode(){
        //given
        Node rootNode = new Circle();
        Node nodeToAdd = new Circle();
        draggable = new Draggable.Nature(rootNode);

        //when
        draggable.addDraggedNode(nodeToAdd);

        //then
        Assertions.assertThat(draggable.getDragNodes().size()).isEqualTo(2);
    }
    
}