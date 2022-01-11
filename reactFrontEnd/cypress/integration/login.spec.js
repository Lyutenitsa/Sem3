describe('The Login Page', () => {
    beforeEach(() => {
        cy.visit('http://localhost:3000/login')
    })
    it('successfully goes to login', () => {
        //   cy.visit('http://localhost:3000/login') // change URL to match your dev URL
        cy.url().should('include', '/login')
    })
    it('Tries to login with missing credentials', () => {
        // cy.visit('http://localhost:3000/login')
        cy.get(':nth-child(1) > div > .form-control')
            .type('Lyutenitsa')
            .should('have.value', 'Lyutenitsa')

        cy.get('.btn').click()
        cy.url().should('include', 'login' )
        cy.get('.alert').should('exist')

        
    })
    it('Tries to login with missing credentials', () => {
        // cy.visit('http://localhost:3000/login')
        cy.get(':nth-child(2) > div > .form-control')
            .type('123123')
            .should('have.value', '123123')

        cy.get('.btn').click()
        cy.url().should('include', 'login' )
        cy.get('.alert').should('exist')
        
    })
    it('Tries to login with no credentials', () => {
        // cy.visit('http://localhost:3000/login')
        

        cy.get('.btn').click()
        cy.url().should('include', 'login' )
        cy.get('.alert').should('exist')
        
    })
    it('Tries to login with incorrect credentials', () => {
        // cy.visit('http://localhost:3000/login')

        cy.get(':nth-child(1) > div > .form-control')
            .type('qqweqwe')
            .should('have.value', 'qqweqwe')

        cy.get(':nth-child(2) > div > .form-control')
            .type('qqweqwe')
            .should('have.value', 'qqweqwe')

        cy.get('.btn').click()

        cy.url().should('include', '/login')
        cy.get('.alert').should('exist')

    })
    it('Tries to login with correct credentials', () => {
        // cy.visit('http://localhost:3000/login')

        cy.get(':nth-child(1) > div > .form-control')
            .type('Lyutenitsa')
            .should('have.value', 'Lyutenitsa')

        cy.get(':nth-child(2) > div > .form-control')
            .type('123123')
            .should('have.value', '123123')

        cy.get('.btn').click()

        cy.url().should('include', '/profile')
    })

})