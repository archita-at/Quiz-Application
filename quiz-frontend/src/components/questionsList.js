import { Component } from "react";
import { Container } from "react-bootstrap";

class QuestionsList extends Component{
    constructor(props){
        super(props);
        this.state = {
            questions: []
        };
    };

    componentDidMount(){
        fetch('http://localhost:8080/api/v1/questions')
            .then(response => response.json())
            .then(data => this.setState({
                questions:data
            }));
    }

    render(){
        const allQuestions = this.state.questions;
        return(<Container>
            <h1>ALL QUESTIONS</h1>
            {allQuestions.map((question, key) => (
                    <div key={key}>
                        <p>Q{question.questionId}. {question.questionStatement}</p>
                        <p>A{question.questionId}. {question.correctAnswer}</p>
                    </div>
                )
            )}
        </Container>)
    }
}

export default QuestionsList;