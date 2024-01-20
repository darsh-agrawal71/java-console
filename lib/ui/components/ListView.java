package lib.ui.components;

import lib.ui.contracts.DisplayableUIElement;
import lib.ui.contracts.UIElementWithContent;

import java.util.List;
import java.util.function.Consumer;

/**
 * Displays a list of {@link ListItem}s. <br>
 * Has two types: Ordered (&lt;ol&gt; in HTML) and Unordered (&lt;ul&gt; in HTML). <br>
 */
public class ListView implements DisplayableUIElement, UIElementWithContent {

    private final List<ListItem> items;
    private final ListType listType;

    /**
     * Specifies the type of list.
     */
    public enum ListType {
        ORDERED,
        UNORDERED;
    }

    public ListView(ListItem... items) { 
        this(List.of(items)); 
    }

    public ListView(ListType type, ListItem... items) {
        this(type, List.of(items));
    }

    public ListView(List<ListItem> items) {
        this(ListType.ORDERED, items);
    }

    public ListView(ListType listType, List<ListItem> items) {
        this.items = items;
        this.listType = listType;
    }

    @Override
    public void display() {
        System.out.println(getContent());
    }

    @Override
    public String getContent() {
        StringBuilder builder = new StringBuilder();
        this.items.forEach(new Consumer<ListItem>() {
            @Override
            public void accept(ListItem item) {
                // Convert 0-based index to 1-based index
                final int index = ListView.this.items.indexOf(item) + 1;

                char itemMarker;
                switch (listType) {
                    case ORDERED:
                        itemMarker = Character.forDigit(index, Res.values.decimal_radix);
                        break;
                    case UNORDERED:
                        itemMarker = Res.strings.asterisk;
                        break;
                    default:
                        throw new IllegalArgumentException();
                }
                item.setItemMarker(itemMarker);
                builder.append(item.getContent());
            }
        });
        return builder.toString();
    }
}