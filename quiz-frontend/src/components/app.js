import { Component } from 'react';
import { Container } from 'react-bootstrap';
import AddQuestionForm from './addQuestionForm';
import QuestionsList from './questionsList';

class App extends Component{
    constructor(props){
        super(props);

        this.state = {
            showQuestionsList: false
        };
    }

    render(){
        return(
            <Container>
                <AddQuestionForm/>
                <hr />
                <QuestionsList/>
            </Container>
        )
    }
}

export default App;