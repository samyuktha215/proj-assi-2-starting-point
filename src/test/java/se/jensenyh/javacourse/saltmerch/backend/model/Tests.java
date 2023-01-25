package se.jensenyh.javacourse.saltmerch.backend.model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class Tests {
    static final int id=1;
    static final String category="hats";
    static final String title="Some Hat 1";
    static final String description="This is some hat 1";
    static final String previewImage= "preview Image";
    @Test
    public void productEmptyConstructorInitializesColorVariants(){
        Product product=new Product();
         assertThat(product.id).isNotNull();
    }
    @Test
    public void productConstructorInitializesColorVariantsAndSetsFields(){
        Product product=new Product(1,"hats","Some Hat 1","This is some hat 1","preview Image");
        assertThat(product.id).isNotNull();

        assertThat(product.getCategory()).isEqualTo("hats");
        assertThat(product.getTitle()).isEqualTo("Some Hat 1");
        assertThat(product.getDescription()).isEqualTo("This is some hat 1");
        assertThat(product.getPreviewImage()).isEqualTo("preview Image");
    }


}
