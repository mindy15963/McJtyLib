package mcjty.lib.container;

import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.Range;
import com.google.common.collect.TreeRangeSet;

import java.util.Set;

/**
 * A collection of ranges of a given slot type.
 */
public class SlotRanges {
    private SlotDefinition slotType;
    private TreeRangeSet<Integer> treeRangeSet = TreeRangeSet.create();

    public SlotRanges(SlotDefinition slotType) {
        this.slotType = slotType;
    }

    public SlotDefinition getSlotDefinition() {
        return slotType;
    }

    public void addSingle(int index) {
        treeRangeSet.add(Range.singleton(index).canonical(DiscreteDomain.integers()));
    }

    public Set<Range<Integer>> asRanges() {
        return treeRangeSet.asRanges();
    }
}