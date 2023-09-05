package com.linecorp.kotlinjdsl.support.hibernate.reactive.extension

import com.linecorp.kotlinjdsl.querymodel.jpql.delete.DeleteQuery
import com.linecorp.kotlinjdsl.querymodel.jpql.select.SelectQuery
import com.linecorp.kotlinjdsl.querymodel.jpql.update.UpdateQuery
import com.linecorp.kotlinjdsl.render.RenderContext
import com.linecorp.kotlinjdsl.support.hibernate.reactive.JpqlMutinySessionUtils
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import io.mockk.mockkObject
import io.mockk.verifySequence
import org.assertj.core.api.WithAssertions
import org.hibernate.reactive.mutiny.Mutiny
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class MutinySessionExtensionsKtTest : WithAssertions {
    @MockK
    private lateinit var session: Mutiny.Session

    @MockK
    private lateinit var selectQuery: SelectQuery<String>

    @MockK
    private lateinit var updateQuery: UpdateQuery<String>

    @MockK
    private lateinit var deleteQuery: DeleteQuery<String>

    @MockK
    private lateinit var queryParams: Map<String, Any?>

    @MockK
    private lateinit var context: RenderContext

    @BeforeEach
    fun setUp() {
        mockkObject(JpqlMutinySessionUtils)
    }

    @Test
    fun `createQuery - select query`() {
        val query = mockk<Mutiny.Query<String>>()

        // given
        every { JpqlMutinySessionUtils.createQuery(session, selectQuery, context) } returns query

        // when
        val actual = session.createQuery(selectQuery, context)

        // then
        assertThat(actual).isEqualTo(query)

        verifySequence {
            JpqlMutinySessionUtils.createQuery(session, selectQuery, context)
        }
    }

    @Test
    fun `createQuery - select query with query params`() {
        val query = mockk<Mutiny.Query<String>>()

        // given
        every { JpqlMutinySessionUtils.createQuery(session, selectQuery, queryParams, context) } returns query

        // when
        val actual = session.createQuery(selectQuery, queryParams, context)

        // then
        assertThat(actual).isEqualTo(query)

        verifySequence {
            JpqlMutinySessionUtils.createQuery(session, selectQuery, queryParams, context)
        }
    }

    @Test
    fun `createQuery - update query`() {
        val query = mockk<Mutiny.Query<String>>()

        // given
        every { JpqlMutinySessionUtils.createQuery(session, updateQuery, context) } returns query

        // when
        val actual = session.createQuery(updateQuery, context)

        // then
        assertThat(actual).isEqualTo(query)

        verifySequence {
            JpqlMutinySessionUtils.createQuery(session, updateQuery, context)
        }
    }

    @Test
    fun `createQuery - update query with query params`() {
        val query = mockk<Mutiny.Query<String>>()

        // given
        every { JpqlMutinySessionUtils.createQuery(session, updateQuery, queryParams, context) } returns query

        // when
        val actual = session.createQuery(updateQuery, queryParams, context)

        // then
        assertThat(actual).isEqualTo(query)

        verifySequence {
            JpqlMutinySessionUtils.createQuery(session, updateQuery, queryParams, context)
        }
    }

    @Test
    fun `createQuery - delete query`() {
        val query = mockk<Mutiny.Query<String>>()

        // given
        every { JpqlMutinySessionUtils.createQuery(session, deleteQuery, context) } returns query

        // when
        val actual = session.createQuery(deleteQuery, context)

        // then
        assertThat(actual).isEqualTo(query)

        verifySequence {
            JpqlMutinySessionUtils.createQuery(session, deleteQuery, context)
        }
    }

    @Test
    fun `createQuery - delete query with query params`() {
        val query = mockk<Mutiny.Query<String>>()

        // given
        every { JpqlMutinySessionUtils.createQuery(session, deleteQuery, queryParams, context) } returns query

        // when
        val actual = session.createQuery(deleteQuery, queryParams, context)

        // then
        assertThat(actual).isEqualTo(query)

        verifySequence {
            JpqlMutinySessionUtils.createQuery(session, deleteQuery, queryParams, context)
        }
    }
}
