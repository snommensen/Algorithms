package quickfind

import org.junit.Before
import org.junit.Test

import static org.hamcrest.CoreMatchers.is
import static org.hamcrest.MatcherAssert.assertThat

class UFQuickFindTest {

    def UFQuickFind quickFind

    @Before
    public void setUp() throws Exception {
        quickFind = new UFQuickFind()
    }

    @Test
    public void union_3and4andThen3and8() throws Exception {
        int first = 3
        int second = 4
        quickFind.union(first, second)

        assertThat(quickFind.objects[first], is(second))

        first = 3
        second = 8
        quickFind.union(first, second)

        assertThat(quickFind.objects[4], is(second))
        assertThat(quickFind.objects[first], is(second))

        println(quickFind)
    }

    @Test
    public void connected_union3and4_3and4areConnected() throws Exception {
        int first = 3
        int second = 4
        quickFind.union(first, second)

        assertThat(quickFind.connected(first, second), is(true))
    }

    @Test
    public void connected_union3and4andThen3and8_3and8areConnected() throws Exception {
        int first = 3
        int second = 4
        quickFind.union(first, second)

        assertThat(quickFind.connected(first, second), is(true))

        first = 3
        second = 8
        quickFind.union(first, second)

        assertThat(quickFind.connected(first, second), is(true))
    }
}
