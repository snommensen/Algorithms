package quickfind

import org.junit.Before
import org.junit.Test

import static org.hamcrest.CoreMatchers.is
import static org.hamcrest.MatcherAssert.assertThat

class UFQuickFindTest {

    def UFQuickFind unionFind

    @Before
    public void setUp() throws Exception {
        unionFind = new UFQuickFind()
    }

    @Test
    public void union_3and4andThen3and8() throws Exception {
        int first = 3
        int second = 4
        unionFind.union(first, second)

        assertThat(unionFind.objects[first], is(second))

        first = 3
        second = 8
        unionFind.union(first, second)

        assertThat(unionFind.objects[4], is(second))
        assertThat(unionFind.objects[first], is(second))

        unionFind.printIds()
    }

    @Test
    public void connected_union3and4_3and4areConnected() throws Exception {
        int first = 3
        int second = 4
        unionFind.union(first, second)

        assertThat(unionFind.connected(first, second), is(true))
    }

    @Test
    public void connected_union3and4andThen3and8_3and8areConnected() throws Exception {
        int first = 3
        int second = 4
        unionFind.union(first, second)

        assertThat(unionFind.connected(first, second), is(true))

        first = 3
        second = 8
        unionFind.union(first, second)

        assertThat(unionFind.connected(first, second), is(true))
    }
}
