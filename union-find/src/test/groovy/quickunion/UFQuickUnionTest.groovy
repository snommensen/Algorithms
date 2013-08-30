package quickunion

import org.junit.Before
import org.junit.Test

import static org.hamcrest.CoreMatchers.is
import static org.hamcrest.MatcherAssert.assertThat

class UFQuickUnionTest {

    def UFQuickUnion quickUnion

    @Before
    public void setUp() throws Exception {
        quickUnion = new UFQuickUnion(100)
    }

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

    @Test
    public void union_3and19andThen3and78_3and19and78areConnected() throws Exception {
        int first = 3
        int second = 19
        quickUnion.union(first, second)

        assertThat(quickUnion.connected(first, second), is(true))

        first = 3
        second = 78
        quickUnion.union(first, second)

        assertThat(quickUnion.connected(first, second), is(true))
        assertThat(quickUnion.connected(19, second), is(true))
        assertThat(quickUnion.connected(first, 19), is(true))

        println(quickUnion)
    }
}
