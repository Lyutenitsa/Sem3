describe('The Signup Page', () => {
    beforeEach(() => {
        cy.visit('http://localhost:3000/register')
    })
    it('successfully goes to register', () => {
        cy.url().should('include', '/register')
    })
    it('Tries to register with missing credentials', () => {
        cy.get(':nth-child(1) > div > .form-control')
            .type('Lyutenitsa')
            .should('have.value', 'Lyutenitsa')

        cy.get('.btn').click()
        cy.url().should('include', 'register')
        cy.get('.alert').should('exist')


    })
    it('Tries to register with missing credentials', () => {
        cy.get(':nth-child(2) > div > .form-control')
            .type('123123')
            .should('have.value', '123123')

        cy.get('.btn').click()
        cy.url().should('include', 'register')
        cy.get('.alert').should('exist')

    })
    it('Tries to register with no credentials', () => {

        cy.get('.btn').click()
        cy.url().should('include', '/register')
        cy.get('.alert').should('exist')

    })
    it('Tries to register with wrong email', () => {

        cy.get(':nth-child(1) > div > .form-control')
            .type('123')
            .should('have.value', '123')

        cy.get(':nth-child(2) > div > .form-control')
            .type('123')
            .should('have.value', '123')
        cy.get(':nth-child(3) > div > .form-control')
            .type('123123')
            .should('have.value', '123123')

        cy.get('.btn').click()

        cy.url().should('include', '/register')
        cy.get('.alert').should('exist')

    })

    it('Tries to register with wrong password', () => {

        cy.get(':nth-child(1) > div > .form-control')
            .type('123')
            .should('have.value', '123')

        cy.get(':nth-child(2) > div > .form-control')
            .type('123@email.com')
            .should('have.value', '123@email.com')
        cy.get(':nth-child(3) > div > .form-control')
            .type('123')
            .should('have.value', '123')

        cy.get('.btn').click()

        cy.url().should('include', '/register')
        cy.get('.alert').should('exist')

    })
})