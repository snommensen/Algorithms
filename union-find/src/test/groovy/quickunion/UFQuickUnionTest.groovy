package quickunion

import org.junit.Test

import static org.hamcrest.CoreMatchers.is
import static org.hamcrest.MatcherAssert.assertThat

class UFQuickUnionTest {

    def UFQuickUnion quickUnion = new UFQuickUnion()

    @Test
    public void union_3and4_3and4areConnected() throws Exception {
        int first = 3
        int second = 4
        quickUnion.union(first, second)

        assertThat(quickUnion.connected(first, second), is(true))
    }

    @Test
    public void union_3and4andThen3and8_3and4and8areConnected() throws Exception {
        int first = 3
        int second = 4
        quickUnion.union(first, second)

        assertThat(quickUnion.connected(first, second), is(true))

        first = 3
        second = 8
        quickUnion.union(first, second)

        assertThat(quickUnion.connected(first, second), is(true))

        println(quickUnion)
    }
}
