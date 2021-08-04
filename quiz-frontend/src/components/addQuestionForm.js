import { Component } from "react";

import { Container, FormControl, InputGroup, Button } from "react-bootstrap";

class AddQuestionForm extends Component{
    constructor(props){
        super(props);
        this.state={
            question: "",
            answer: "",
            allQuestions: []
        }

        this.handleInputChange = this.handleInputChange.bind(this);
        this.submitQuestion = this.submitQuestion.bind(this);
    }

    handleInputChange(e){
        const { name, value } = e.target;
        this.setState({
            [name]: value,
        });
    }

    submitQuestion(){
        const {question, answer} = this.state;
        if(question!=="" && answer !== ""){
            const requestOptions = {
                method: 'POST',
                headers: { 'Content-Type':'application/json'},
                body: JSON.stringify({"questionStatement": question, "correctAnswer":answer})
            };
            fetch('http://localhost:8080/api/v1/add-question', requestOptions)
                .then(response => response.json())
                .then(data => {
                    this.setState({
                        question: data.questionStatement,
                        answer: data.correctAnswer
                    });
                });
        }
    }

    render(){
        return(<Container>
            <h1>ENTER QUESTION</h1>
            <InputGroup>
                <FormControl placeholder="Enter Question"
                    name="question"
                    value={this.state.question}
                    onChange={item => this.handleInputChange(item)}/>
                <FormControl placeholder="Enter Answer"
                    name="answer"
                    value={this.state.answer}
                    onChange={item => this.handleInputChange(item)}/>
                <Button onClick={() => this.submitQuestion()}>Add Question</Button>
            </InputGroup>
        </Container>);
    }
}

export default AddQuestionForm;